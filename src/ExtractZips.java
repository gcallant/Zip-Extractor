import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Grant Callant on 1/22/2015.
 * @author Grant Callant
 */
public class ExtractZips
	{
		public static void main(String [] args)
			{

				String destination = null;

				String pathName = null;
				//String [] src = new String [129];
				Scanner input = new Scanner(System.in);

				System.out.println("Enter the pathname");
				pathName = input.nextLine();



				File file = new File(pathName);
				ArrayList<File> list = new ArrayList<File>(3);
				while(!file.exists())
					{
						System.out.println("That directory doesn't exist, try again.");
						pathName = input.nextLine();
						file = new File(pathName);
					}

				System.out.println("Enter the destination directory.");
				destination = input.nextLine();



				String [] src = getAllFiles(file, list);


				for(int i = 0; i < src.length; i++)
					{
						String source = null;
						source = src[i];





						//String password = "password";
				for(int x = i; x <= i; x++)
					{
						try
							{
								ZipFile zipFile = new ZipFile(source);
								if(zipFile.isEncrypted())
									{
										//zipFile.setPassword(password);
									}
								zipFile.extractAll(destination);
							} catch(ZipException e)
							{
								e.printStackTrace();
							}

					}
				}






			}
	}
