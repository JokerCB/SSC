package framework.generic.utils.pdf;

import com.lowagie.text.pdf.PdfEncryptor;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 13-9-23
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public class PDFUtil {
    /**
     * 根据传入的path跟url链接生成PDF文件 （采用kwhtmltopdf）
     * @param kwhtmltopdf
     * @param pdfFile
     * @param parseUrl
     * @return
     * @throws Exception
     */
    public static InputStream URL2PDFFile(String kwhtmltopdf,String pdfFile, String parseUrl) throws Exception {

        File Pdf = new File(pdfFile); // pdf文件
        if (!Pdf.exists()) {
            Pdf.createNewFile();
        }

        ProcessBuilder processBuilder = new ProcessBuilder(prepareWkhtmltopdfCommand(kwhtmltopdf,pdfFile, parseUrl));

        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        process.destroy();

        pdfEncryption(pdfFile);

        return new FileInputStream(pdfFile);
    }

    /**
     * 根据传入的path跟url链接生成PDF文件 (采用phantomjs)
     * @param phantomjsBin
     * @param phantomjsScript
     * @param pdfFile
     * @param parseUrl
     * @return
     * @throws Exception
     */
    public static InputStream URL2PDFFile(String phantomjsBin,String phantomjsScript,String pdfFile, String parseUrl) throws Exception {

        File Pdf = new File(pdfFile); // pdf文件
        if (!Pdf.exists()) {
            Pdf.createNewFile();
        }

        ProcessBuilder processBuilder = new ProcessBuilder(preparePhantomJSCommand(phantomjsBin,phantomjsScript,pdfFile, parseUrl));

        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        process.destroy();

        pdfEncryption(pdfFile);

        return new FileInputStream(pdfFile);
    }
    /**
     * 调用wkhtmltopdf命令行
     * @param kwhtmltopdf
     * @param pdfFile
     * @param parseUrl
     * @return
     */
    private static List<String> prepareWkhtmltopdfCommand(String kwhtmltopdf, String pdfFile, String parseUrl) {
        final List<String> commands = new ArrayList<String>();
        commands.add(kwhtmltopdf);
        commands.add("--zoom");
        commands.add("1.5");
        commands.add(parseUrl);
        commands.add(pdfFile);
        return commands;
    }

    /**
     * 调用phantomjs命令行
     * @param phantomjsBin
     * @param phantomjsScript
     * @param pdfFile
     * @param parseUrl
     * @return
     */
    private static List<String> preparePhantomJSCommand(String phantomjsBin, String phantomjsScript, String pdfFile, String parseUrl) {
        final List<String> commands = new ArrayList<String>();
        commands.add(phantomjsBin);
        commands.add(phantomjsScript);
        commands.add(parseUrl);
        commands.add(pdfFile);
        commands.add("2.0");
        return commands;
    }

    /**
     * 对PDF文件加密
     * @param pdfFile
     * @throws Exception
     */
    private static void pdfEncryption(String pdfFile) throws Exception {
        PdfReader reader = new PdfReader(new FileInputStream(pdfFile));
        PdfEncryptor.encrypt(reader,
                new FileOutputStream(pdfFile),
                null,
                null,
                PdfWriter.ALLOW_PRINTING,
                false);
    }

    /**
     * 对PDF文件叫密
     * @param pdfFile （PDF文件）
     * @param userPassword （用户密码）
     * @param ownerPassword   （文档server端password）
     * @throws Exception
     */
    private static void pdfEncryption(String pdfFile,String userPassword,String ownerPassword) throws Exception {
        PdfReader reader = new PdfReader(new FileInputStream(pdfFile));
        PdfEncryptor.encrypt(reader,
                new FileOutputStream(pdfFile),
                userPassword.getBytes(),
                ownerPassword.getBytes(),
                PdfWriter.ALLOW_PRINTING,
                false);
    }

}
