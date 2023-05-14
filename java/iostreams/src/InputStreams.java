import java.io.*;

/**
 * Explore different input streams in java
 */
public final class InputStreams {
    public static void main(String[] args) {
        System.out.println("----------------------FileInputStream---------------------------------");
        exploreFileInputStream();

        System.out.println("----------------------ByteArrayInputStream-----------------------------");
        exploreByteArrayInputStream();

        System.out.println("-----------------------PipedInputStream--------------------------------");
        explorePipedInputStream();

        System.out.println("------------------------DataInputStream--------------------------------");
        exploreDataInputStream();

        System.out.println("------------------------ObjectInputStream-----------------------------");
        exploreObjectInputStream();
    }

    private static void exploreFileInputStream(){
        /*
        * Important point to note is, whenever we use streams, we should make sure to close the stream
        * Below i haven't used close() method explicitly, because InputStream implements AutoClosable interface
        * And any class that implements AutoClosable, if used in try with resources, gets closed automatically,
        * because finally is by default added to try with resources block and close() method is executed too,
        * without explicit implementation
        * */
        try(InputStream fileInputStream = new FileInputStream("src/input-test.txt")){
            int s = 0;
            while((s = fileInputStream.read()) != -1){
                System.out.print((char)s);
            }
            System.out.println();
        } catch (FileNotFoundException fex){
            System.err.println(fex.getStackTrace());
        } catch (Exception ex){
            System.err.println(ex.getStackTrace());
        }
    }

    private static void exploreByteArrayInputStream(){
        byte[] byteArr = { 65, 66, 67, 123, 78, 89};
        try(InputStream byteInputStream = new ByteArrayInputStream(byteArr)){
//            int s = 0;
//            while((s = byteInputStream.read()) != -1){
//                //prints the ASCII values from the buffer array
//                System.out.print((char)s + " ");
//            }

            int byteStLen = byteInputStream.available();
            byte[] buff = new byte[byteStLen];
            //read only specified length of data from a specific offset
            byteInputStream.read(buff, 3, 2);
            for(byte b : buff){
                System.out.println((char)b + " " + b);
            }
        } catch (FileNotFoundException fex){
            System.err.println(fex.getStackTrace());
        } catch (Exception ex){
            System.err.println(ex.getStackTrace());
        }
    }

    /**
     * Piped Streams are meant for inter thread communication,
     * where a pipe is created between 2 threads and one thread writes to the pipe using piped output stream
     * and another thread reads from pipe using piped input stream
     */
    private static void explorePipedInputStream(){
        try(PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream)) {

            //below is an alternative to create connection between piped input stream and piped output stream
            //pipedInputStream.connect(pipedOutputStream);

            //write to pipe
            pipedOutputStream.write(1);
            pipedOutputStream.write(2);
            pipedOutputStream.write(3);

            //read from pipe
            byte[] pipeBuff = new byte[pipedInputStream.available()];
            pipedInputStream.read(pipeBuff);
            for (byte b : pipeBuff) {
                System.out.print(b + " ");
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
    private static void exploreDataInputStream(){
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

    private static class Student implements Serializable {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * Object input stream is used to read the objects
     */
    private static void exploreObjectInputStream(){
        //write data object to a file using object output stream
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/object.dat"))){
            Student student = new Student();
            student.setId(1);
            student.setName("Sandeep");
            objectOutputStream.writeObject(student);
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        //read data object from a file using object input stream
        try(ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream("src/object.dat"))){
            Student readStudent = (Student)objectOutputStream.readObject();
            System.out.println(readStudent.getId());
            System.out.println(readStudent.getName());
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

}
