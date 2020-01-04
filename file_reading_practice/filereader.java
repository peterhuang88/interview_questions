import java.io.*;

public class filereader {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            in = new FileInputStream("meme.txt");
            out = new FileOutputStream("new_meme.txt");

            br = new BufferedReader(new InputStreamReader(in));
            bw = new BufferedWriter(new OutputStreamWriter(out));

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.write("\n");
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                br.close();
                bw.close(); 
                in.close();
                out.close();
            } catch (IOException i) {
                System.out.println(i);
            }
        }

    }
}
