package com.vhly.epubmaker;

import com.vhly.epubmaker.epub.EPubFile;
import com.vhly.epubmaker.epub.Item;
import com.vhly.epubmaker.epub.content.Chapter;

/**
 * Created by IntelliJ IDEA.
 * User: vhly[FR]
 * Date: 11-12-2
 * Email: vhly@163.com
 */
public class MakeTest {
    public static void main(String[] args) {
        EPubFile file = new EPubFile();
        Chapter ch = new Chapter();
        ch.setTitle("Chapter001");
        ch.setEntryName("chapter001.html");
        ch.setPageContent("<html><body>Hello world</body></html>");
        Item chapterItem = new Item("chapter001.html","chapter001.html");
        ch.setChapterItem(chapterItem);
        file.addChapter(ch);
        file.save("./MakeTest.epub");
    }
}
