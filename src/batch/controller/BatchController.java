package batch.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class BatchController
{

	public void start()
	{
		// TODO Auto-generated method stub

	}

	public BatchController()
	{

		String text = "0";

		if (checkContents(readAllGameInformation(), "Logon Successful"))
		{
			try
			{
				text = "1";
				File file = new File("C:/Auth/result.txt");
				BufferedWriter output = new BufferedWriter(new FileWriter(file));
				output.write(text);
				output.close();

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			System.out.print(text);
		}
		else
		{
			try
			{
				text = "0";
				File file = new File("C:/Auth/result.txt");
				BufferedWriter output = new BufferedWriter(new FileWriter(file));
				output.write(text);
				output.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			System.out.print(text);
		}
	}

	private String readAllGameInformation()
	{
		String fileContents = "";
		String fileName = "C:/Auth/result.txt";
		// String fileName = "C:/Auth/New Text Document.bat";
		File currentSaveFile = new File(fileName);
		Scanner fileReader;

		try
		{
			fileReader = new Scanner(currentSaveFile);
			while (fileReader.hasNext())
			{
				fileContents += fileReader.nextLine();
			}
			fileReader.close();
		}
		catch (FileNotFoundException fileDoesNotExist)
		{
			JOptionPane.showMessageDialog(null, fileDoesNotExist.getMessage());
		}
		return fileContents;

	}

	public boolean checkContents(String current, String checkText)
	{
		boolean isThere = false;

		if (current.contains(checkText))
		{
			isThere = true;
		}
		return isThere;
	}

}
