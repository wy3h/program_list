package blockingQueue;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class BlockingQueueTest
{
	private static final int FILE_QUEUE_SIZE = 10;
	private static final int SEARCH_THEADS = 100;
	private static final File DUMMY = new File("");
	private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
	
	public static void main(String[] args)
	{
		try(Scanner in = new Scanner(System.in))
		{
			System.out.print("Enter base directory (eg. /opt/jdk1.8.0/src):");
			String directory = in.nextLine();
			System.out.print("Eneter keyword(eg. volatile)");
			String keyword = in.nextLine();
			
			Runnable enumerator = () ->{
				try
				{
					enumerate(new File(directory));
					queue.put(DUMMY);
				}
				catch(InterruptedException e)
				{
				}
			};
			
			new Thread(enumerator).start();
			for (int i = 1; i <= SEARCH_THEADS; i++){
				Runnable searcher = () -> {
					try 
					{
						boolean done = false;
						while(!done)
						{
							File file = queue.take();
							if(file == DUMMY)
							{
								queue.put(file);
								done = true;
							}
							else search(file, keyword);
						}
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					catch(InterruptedException e)
					{
					}
				};
				new Thread(searcher).start();
			}
		}
	}
	
	/**
	 * Recursively enumerates all files in a given directory and its subdirectory.
	 * @param directory the directory in which to start
	 */
	public static void enumerate(File directory) throws InterruptedException
	{
		File[] files = directory.listFiles();
		for(File file : files)
		{
			if (file.isDirectory()) enumerate(file);
			else queue.put(file);
		}
	}
	
	/**
	 * Search a file for a given keyword and prints all matching lines.
	 * @param file the file to search
	 * @param keyword the keywrod to search for
	 */
	public static void search(File file, String keyword) throws IOException
	{
		try (Scanner in = new Scanner(file, "UTF-8"))
		{
			int lineNumber = 0;
			while (in.hasNextLine())
			{
				lineNumber++;
				String line = in.nextLine();
				if(line.contains(keyword))
					System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
			}
		}
	}
}
