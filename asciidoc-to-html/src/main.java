/**
Author: Tom Jennings
Open Liberty
*/
import java.io.*;

public class main {
		public static void main(String[] args) 
		{
			try {
		         String text = "";
		         int lineNumber;
		          FileReader readfile = new FileReader("asciidoc.txt");
		          BufferedReader readbuffer = new BufferedReader(readfile);
		          for (lineNumber = 1; lineNumber < 447; lineNumber++) 
		          {
		            if (lineNumber == 446) 
		            {
		              text = readbuffer.readLine();
		            } 
		            else
		              readbuffer.readLine();
		          }
		          
		          while (text != null) 
		          {
						//Paragraphs
						text = text.replace("<p>","");
						text = text.replace("</p>", "");
						//Division
						text = text.replace("</div>","");
						text = text.replace("<div class=\"sectionbody\">", "");
						text = text.replace("<div class=\"paragraph\">", "");
						text = text.replace("<div class=\"listingblock\">", "");
						text = text.replace("<div class=\"content\">", "");
						text = text.replace("<div id=\"footer\">", "");
						text = text.replace("<div id=\"footer-text\">", "");
						text = text.replace("<div class=\"sect1\">", "");

						//unordered and list
						//text = text.replace("<ul>", "");
						//text = text.replace("</ul>", "");
						//text = text.replace("<li>", "");
						//text = text.replace("</li>", "");
						//Tag Replacement
						text = text.replace("&lt;", "<");
						text = text.replace("&gt;", ">");
						//Apostrophe replacement 
						text = text.replace("&#8217;", "'");
						//code lang ="[xml]
						text = text.replace("<pre class=\"highlight\"><code class=\"language-xml\" data-lang=\"xml\">", "[code lang=" + "\"xml\"]" + "\n");
						text = text.replace("<pre class=\"highlight\"><code class=\"language-gradle\" data-lang=\"gradle\">", "[code lang=" + "\"gradle\"] \n");
						text = text.replace("</code></pre>", "[/code]");
						text = text.replace("</server>[/code]", "</server>" + "\n" + "[/code]");
						text = text.replace("[/code]", "\n" + "[/code]");
						
						text = text.replace("</body>", "");
						text = text.replace("</html>", "");

						System.out.println(text);
						
						
						// read next line
						text = readbuffer.readLine();
					}
					readbuffer.close();
		        } 
		        catch (IOException e) 
		        {
		          e.printStackTrace();
		        }
					
    
		}
}