package com.firefly.utils.log;

import com.firefly.utils.collection.TreeTrie;
import com.firefly.utils.collection.Trie;
import com.firefly.utils.function.Action1;
import com.firefly.utils.log.file.FileLog;
import com.firefly.utils.log.file.FileLogTask;
import com.firefly.utils.time.Millisecond100Clock;
import com.firefly.utils.time.SafeSimpleDateFormat;

public class LogFactory {
	public static final SafeSimpleDateFormat DAY_DATE_FORMAT = new SafeSimpleDateFormat("yyyy-MM-dd");

	private final Trie<Log> logTree = new TreeTrie<>();
	private final LogTask logTask;

	private static class Holder {
		private static LogFactory instance = new LogFactory();
	}

	public static LogFactory getInstance() {
		return Holder.instance;
	}

	private LogFactory() {
		logTask = new FileLogTask(logTree);

		LogConfigParser parser = new XmlLogConfigParser();
		boolean success = parser.parse(new Action1<FileLog>() {

			@Override
			public void call(FileLog fileLog) {
				logTree.put(fileLog.getName(), fileLog);
			}
		});

		if (!success) {
			parser = new PropertiesLogConfigParser();
			success = parser.parse(new Action1<FileLog>() {

				@Override
				public void call(FileLog fileLog) {
					logTree.put(fileLog.getName(), fileLog);
				}
			});
		}

		if (!success) {
			System.out.println("log configuration parsing failure!");
		}

		if (logTree.get(LogConfigParser.DEFAULT_LOG_NAME) == null) {
			FileLog fileLog = parser.createDefaultLog();
			logTree.put(fileLog.getName(), fileLog);
		}

		logTask.start();
	}

	public void flushAll() {
		for (String key : logTree.keySet()) {
			Log log = logTree.get(key);
			if (log instanceof FileLog) {
				((FileLog) log).flush();
			}
		}
	}

	public Log getLog(Class<?> clazz) {
		return getLog(clazz.getName());
	}

	public Log getLog(String name) {
		Log log = logTree.getBest(name);
		if (log != null) {
			return log;
		} else {
			return logTree.get(LogConfigParser.DEFAULT_LOG_NAME);
		}
	}

	public LogTask getLogTask() {
		return logTask;
	}

	public void shutdown() {
		logTask.shutdown();
		Millisecond100Clock.stop();
	}

	public void start() {
		logTask.start();
	}

}
