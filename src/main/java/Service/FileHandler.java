package Service;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public final class FileHandler {

    private static final Logger log = Logger.getLogger(FileHandler.class);

    /**
     * Method to get file from file system
     * @param filePath - full path to file from file system
     * @return File from file system
     */
    public File getFile(String filePath){
        log.info("Enter to method \"getFile()\"");
        return new File(filePath);
    }

    /**
     * Method to get input stream from resource file
     * @param fileName - name of searched file must be received
     * @return InputStream - file as stream
     */
    public InputStream getResourceFileAsInputStream(String fileName){
        log.info("Enter to method \"getResourceFileAsInputStream()\"");
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    /**
     * Method to read file or resource from the application and get as String
     * @param file - Full path to the file, if we chose storeType as FILESYSTEM,
     *                 or name of file if we chose storeType as RESOURCE
     * @param storeType - enum variable which provides method of getting file to read
     * @return
     */
    public String readFromFile(String file, StoreType storeType) {
        StringBuilder sb = new StringBuilder("");
        if (storeType.equals(StoreType.FILESYSTEM)) { // Чтение из файловой системы
            File readableFile = getFile(file);
            try {
                Scanner scanner = new Scanner(readableFile);
                if (scanner.hasNextLine()){
                    sb.append(scanner.nextLine());
                }
                return sb.toString();
            } catch (FileNotFoundException e) {
                log.error("FileNotFoundException: " + e);
                return sb.toString();
            }
        } else { // Чтение из ресурсов
            InputStream inputStream = getResourceFileAsInputStream(file);
            Scanner scanner = new Scanner(inputStream);
            if (scanner.hasNextLine()){
                sb.append(scanner.nextLine());
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                log.error("IOException: " + e);
            }
            return sb.toString();
        }
    }

    /**
     * Method to write string to file in file system
     * @param filePath - full path to file in the file system
     * @param content - passed string
     */
    public void writeToFile(String filePath, String content) {
        log.info("Enter to method \"writeToFile()\"");
        File file = getFile(filePath);
        if (file != null) {
            log.info("File was found!");
            try {
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.append(content);
                log.info("File was written successfully!");
                printWriter.close();
                log.info("File was closed!");
            } catch (FileNotFoundException e) {
                log.error("FileNotFoundException: " + e);
            }
        }
    }

    public enum StoreType {
        RESOURCE, // file from app resource
        FILESYSTEM // file from file system
    }
}