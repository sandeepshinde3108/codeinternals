package readerwriter;

import java.io.*;
import java.nio.CharBuffer;

/**
 * Reader Writer Stream classes are for reading/writing characters
 * as oppose to Input Output stream classes which reads/writes bytes
 */
public class InputOutputReaderWriterStreams {
    public static void main(String[] args) {
        System.out.println("-------------------------InputStreamReader & OutputStreamWriter----------------------");
        exploreInputOutStreamReaderWriter();

        System.out.println("-------------------------File Reader & Writer------------------------------");
        exploreFileReaderWriter();

        System.out.println("--------------------------String Reader & Writer----------------------------");
        exploreStringReaderWriter();

        System.out.println("----------------------------CharArray Reader & Writer---------------------------------");
        exploreCharArrayReaderWriter();

        System.out.println("----------------------------Piped Reader & Writer-----------------------------------");
        explorePipedReaderWriter();
    }

    private static void exploreInputOutStreamReaderWriter(){
        //write
        try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("src/readerwriter/stream-test.txt"))){
            outputStreamWriter.write("Write data using StreamWriter.");
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        //read
        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/readerwriter/stream-test.txt"))){
            int i = 0;
            while((i = inputStreamReader.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println();
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    private static void exploreFileReaderWriter(){
        //write
        try(FileWriter fileWriter = new FileWriter(new File("src/readerwriter/readwrite-test.txt"))){
            fileWriter.write("Hello! How are you?");
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        //read
        try(FileReader fileReader = new FileReader(new File("src/readerwriter/readwrite-test.txt"))){
            int i = 0;
            while((i = fileReader.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println();
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    private static void exploreStringReaderWriter(){
        //write
        try(StringWriter stringWriter = new StringWriter(6)){
            stringWriter.write("Hello");

            System.out.println(stringWriter.toString());
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }


        //read
        // converts string into character stream
        try(StringReader stringReader = new StringReader("Good")){
            int i = 0;
            while((i = stringReader.read()) != -1){
                System.out.print((char)i);
            }
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        System.out.println();
    }

    private static void exploreCharArrayReaderWriter(){
        //write
        try(CharArrayWriter charArrayWriter = new CharArrayWriter()){
            charArrayWriter.write('b');
            charArrayWriter.write('y');
            charArrayWriter.write('e');

            System.out.println(charArrayWriter.toString());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        //read
        char[] charArray = {'t','e','s','t'};
        try(CharArrayReader charArrayReader = new CharArrayReader(charArray)){
            int i = 0;
            while((i = charArrayReader.read()) != -1){
                System.out.print((char)i);
            }
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        System.out.println();
    }

    private static void explorePipedReaderWriter(){
        try(PipedWriter writer = new PipedWriter();
            PipedReader reader = new PipedReader()) {
            reader.connect(writer);
            writer.write("HELLO");

            int i = 0;
            while((i = reader.read()) != -1){
                System.out.print((char)i);
            }
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        System.out.println();
    }
}

