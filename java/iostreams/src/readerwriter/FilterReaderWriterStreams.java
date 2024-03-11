package readerwriter;

import java.io.*;

public class FilterReaderWriterStreams {
    public static void main(String[] args) {

        System.out.println("----------------------PushBack Reader--------------------------------");
        explorePushBackReader();

    }

    private static void explorePushBackReader(){
        try(PushbackReader pushbackReader = new PushbackReader(new FileReader("src/readerwriter/readwrite-test.txt"))){
            int readChar = pushbackReader.read();
            System.out.println("Character read: " + (char)readChar);

            pushbackReader.unread(readChar);
            System.out.println("Marked read character unread");

            readChar = pushbackReader.read();
            System.out.println("Character read: " + (char)readChar);
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        System.out.println();
    }
}
