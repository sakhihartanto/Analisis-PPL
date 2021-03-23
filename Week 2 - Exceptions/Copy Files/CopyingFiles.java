package CopyFilesJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author User
 */
class CopyingFiles{
    public static void CopyFiles() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name Files Here : ");
        String fn = sc.nextLine();
        
        File file = new File(fn);
        try{
            sc = new Scanner(file, StandardCharsets.UTF_8.name());
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("File Not Found !");
            CopyFiles();
        }
    }
    public static void main(String[] args) {
        CopyFiles();
    }
}
