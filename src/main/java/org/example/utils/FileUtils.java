package org.example.utils;

import org.example.constants.AppConstants;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class FileUtils {
    public static final Charset CHARSET = StandardCharsets.UTF_8;
    public static final String MISC_DIR = "src/main/resources/misc";

    private FileUtils() {
    }

    /**
     * Determines if the path leads to a readable file.
     *
     * @param path the filePath
     * @return true, if the file is executable
     */
    public static boolean isReadableFile(Path path) {
        return (path != null) && path.toFile().isFile() && Files.isReadable(path);
    }

    /**
     * Determines if the path leads to a writable file.
     *
     * @param path the filePath
     * @return true, if the file is writable
     */
    public static boolean isWritableFile(Path path) {
        return isReadableFile(path) && Files.isWritable(path);
    }

    /**
     * Determines if the file path contains an existing executable file.
     *
     * @param path the file path
     * @return true, if the file already exists
     */
    public static boolean isExistingFile(Path path) {
        return isReadableFile(path) && isWritableFile(path) && Files.exists(path, LinkOption.NOFOLLOW_LINKS);
    }

    /**
     * Opens and then reads the contents of an executable file.
     *
     * @param path the filePath
     * @return the textual contents of the file
     */
    public static String readFileFrom(Path path) {
        try {
            if (isReadableFile(path)) {
                return Files.readString(path, CHARSET);
            } else
                throw new IOException("'" + path + "' is not a valid filePath!");
        } catch (IOException e) {
            AppConstants.printError(e);
            return "";
        }
    }

    /**
     * Locks the executable file to the current writer, and then writes data to it.
     *
     * @param file    the file to be saved
     * @param content the data being written to the executable file.
     */
    public static void lockAndSave(File file, String content) {
        final FileLock fileLock;
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file.getName(), "rw");
             FileChannel fileChannel = randomAccessFile.getChannel()) {

            if (StringUtils.isNotEmpty(content)) {
                var savedFile = new File(file.getAbsolutePath());
                var savedFilePath = savedFile.toPath();

                //TODO: Bug found: When updaing an existing file, the first line is appended twice;
                if (savedFile.createNewFile() && isWritableFile(savedFilePath) || isExistingFile(savedFilePath)) {
                    final String savedFileName = savedFile.getName();
                    fileLock = fileChannel.tryLock();

                    randomAccessFile.writeChars("Locking " + savedFileName + " for write access.");
                    Files.writeString(savedFilePath, content, StandardOpenOption.TRUNCATE_EXISTING);

                    randomAccessFile.writeChars("Unlocking " + savedFileName);
                    System.out.println("Saved: " + savedFileName);
                    fileLock.release();
                } else
                    throw new IOException("An Error occurred when saving to '" + file.getName() + "'!");
            } else
                throw new IOException("'" + content + "' is not a valid file content!");
        } catch (IOException e) {
            AppConstants.printError(e);
        }
    }

}
