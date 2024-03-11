import java.io.*;

public class FilterInputOutputStreams {
    public static void main(String[] args) {

        System.out.println("-----------------------BufferedInputStream & BufferedOutputStream-------------------------");
        exploreBufferedInputOutputStream();

        System.out.println("------------------------DataInputStream & DataOutputStream--------------------------------");
        exploreDataInputOutputStream();

        System.out.println("------------------------PushBackInputStream----------------------------------------");
        explorePushBackInputStream();

        System.out.println("-------------------------PrintStream-------------------------------------------");
        explorePrintStream();
    }

    private static void exploreBufferedInputOutputStream(){
        String msg = "Hello! How are you?";
        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/buffered.txt"))){
            byte[] bytes = msg.getBytes();
            bufferedOutputStream.write(bytes);
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/buffered.txt"))){
            int read = 0;
            while((read = bufferedInputStream.read()) != -1){
                System.out.print((char)read);
            }
            System.out.println();
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Data Input Stream lets reading Java primitive data types from input stream
     */
    private static void exploreDataInputOutputStream(){
        //write primitive data types to a file using DataOutputStream
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src/data.dat"))){
            dataOutputStream.writeInt(10);
            dataOutputStream.writeDouble(3.14);
            dataOutputStream.writeBoolean(false);
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        //read primitive data types froma file using DataInputStream
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/data.dat"))){
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readBoolean());
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    private static void explorePushBackInputStream(){
        try(PushbackInputStream pushbackInputStream = new PushbackInputStream(new FileInputStream("src/input-test.txt"))){
            System.out.println("Available Bytes before read: " + pushbackInputStream.available());

            int readByte = pushbackInputStream.read();
            System.out.println((char)readByte);
            System.out.println("Available Bytes after read: " + pushbackInputStream.available());

            pushbackInputStream.unread(readByte);
            System.out.println("Available Bytes after unread: " + pushbackInputStream.available());

            readByte = pushbackInputStream.read();
            System.out.println((char)readByte);
            System.out.println("Available Bytes after 2nd read: " + pushbackInputStream.available());
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    /**
     * PrintStream is an OutputStream which provides a way to write formatted text to underlying output stream
     * System.out is an instance of PrintStream. System.out is meant to write only on console
     * You can use PrintStream to write on any kind of output stream
     */
    private static void explorePrintStream(){
        try(PrintStream printStream = new PrintStream(new FileOutputStream("src/print.txt"))){
            printStream.println("My name is Sandeep!");
            printStream.println(10);
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
