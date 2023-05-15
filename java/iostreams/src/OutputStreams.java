import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreams {
    public static void main(String[] args) {
        System.out.println("---------------------FileOutputStream-----------------------------");
        exploreFileOutputStream();

        System.out.println("----------------------ByteArrayOutputStream-----------------------");
        exploreByteArrayOutputStream();
    }

    private static void exploreFileOutputStream(){
        try(FileOutputStream fileOutputStream = new FileOutputStream("src/output-test.txt")){
            String msg = "Hello! how are you?";
            fileOutputStream.write(msg.getBytes());
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    private static void exploreByteArrayOutputStream(){
        byte[] byteArr = {23, 34, 45, 56, 67};
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5)){
            byteArrayOutputStream.write(byteArr);

            byte[] buff = byteArrayOutputStream.toByteArray();
            for (byte b :  buff) {
                System.out.println(b);
            }
        } catch (IOException ioEx){
            System.err.println(ioEx.getMessage());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Rest of the output streams are covered in InputStreams class
     */
}
