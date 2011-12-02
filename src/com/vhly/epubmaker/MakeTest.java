package com.vhly.epubmaker;

import com.vhly.epubmaker.epub.EPubFile;
import com.vhly.epubmaker.epub.Item;
import com.vhly.epubmaker.epub.content.Chapter;
import net.dratek.browser.util.StreamUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 11-12-2
 * Email: vhly@163.com
 */
public class MakeTest {
    public static void main(String[] args) {
        EPubFile file = new EPubFile();
        file.setTitle("Test");
        file.setAuthor("vhly[FR]");
        file.setUUID("998482814");
        file.setDescript("This is a Test");

        File f = new File("./cover.jpg");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(f);
            byte[] bytes = StreamUtil.readStream(fin);
            file.setCover("cover.jpg",bytes,"image/jpeg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            StreamUtil.close(fin);
        }

        Chapter ch = new Chapter();
        ch.setTitle("Chapter001");
        ch.setEntryName("chapter001.html");
        ch.setPageContent("<html xmlns=\"http://www.w3.org/1999/xhtml\"><body>Hello world</body></html>");
        Item chapterItem = new Item("chapter001.html","chapter001.html");
        ch.setChapterItem(chapterItem);
        file.addChapter(ch);
        file.save("./MakeTest.epub");
    }
}
