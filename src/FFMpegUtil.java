import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FFMpegUtil {
    private String ffmpegPath;
    private static final String FILE_SEPARATOR = File.separator;
    public static FFMpegUtil self = new FFMpegUtil();

    private FFMpegUtil() {
    }

    public static FFMpegUtil me() {
        return self;
    }

    public FFMpegUtil init(String path) {
        this.ffmpegPath = path;
        return this;
    }

    private static boolean isSurpportedType(String type) {
        Pattern pattern = Pattern.compile(
                "(asx|asf|mpg|wmv|3gp|mp4|mov|avi|flv){1}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(type);
        return matcher.find();
    }

    /**
     * 
     * @param sourceFile
     *            ��Ҫ��ת����Ŀ���ļ�
     * @param desctination
     *            ת��֮���ļ��Ĵ��·�� ffmpeg commandLine�� ffmpeg -y -i
     *            /usr/local/bin/lh.mp4 -ab 56 -ar 22050 -b 500 -s 320x240
     *            /usr/local/bin/lh.flv
     * @throws IOException
     */
    public/* MRecord */void converToFlv(File sourceFile, String destination) {

        String fileName = sourceFile.getName();
        String surffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!isSurpportedType(surffix))
            throw new RuntimeException("unsurpported file type " + surffix);

        List<String> cmdParam = new LinkedList<String>();
        cmdParam.add(ffmpegPath);
        cmdParam.add("-y");
        cmdParam.add("-i");
        cmdParam.add(sourceFile.getAbsolutePath());
        cmdParam.add("-ab");
        cmdParam.add("56");
        cmdParam.add("-ar");
        cmdParam.add("22050");
        cmdParam.add("-b");
        cmdParam.add("500");
        cmdParam.add("-s");
        cmdParam.add("320*240");
        cmdParam.add(destination + FILE_SEPARATOR
                + fileName.substring(0, fileName.lastIndexOf(".")) + ".flv");
        execCmd(cmdParam);

        // return execCmd(cmdParam);
    }

    /**
     * FFMPEG -i uploadfile/video/test.wmv -c:v libx264 -strict -2
     * uploadfile/mp4/test.mp4
     * 
     * ffmepg -i [ԭ��Ƶ.avi] -vcodec libx264 -acodec copy [����Ƶ.mp4]
     */
    public void convertToMp4(File sourceFile, String destination) {
        String fileName = sourceFile.getName();
        String surffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!isSurpportedType(surffix))
            throw new RuntimeException("unsurpported file type " + surffix);

        List<String> cmdParam = new LinkedList<String>();
        cmdParam.add(ffmpegPath);
        /* cmdParam.add("-y"); */
        cmdParam.add("-i");
        cmdParam.add(sourceFile.getAbsolutePath());
        /* cmdParam.add("-c:v"); */
        cmdParam.add("-vcodec");
        cmdParam.add("libx264");
        /* cmdParam.add("-strict -2"); */
        /* cmdParam.add("-acodec copy"); */

        cmdParam.add("-b:v");
        cmdParam.add("800k");

        cmdParam.add("-s");
        cmdParam.add("720*576");
        cmdParam.add(destination + FILE_SEPARATOR
                + fileName.substring(0, fileName.lastIndexOf(".")) + ".mp4");
        System.out.println(cmdParam.toString().replace(",", ""));
        execCmd(cmdParam);
    }

    public void getVideoMsg(File sourceFile) {

        String fileName = sourceFile.getName();
        String surffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!isSurpportedType(surffix))
            throw new RuntimeException("unsurpported file type " + surffix);

        List<String> cmdParam = new LinkedList<String>();
        cmdParam.add(ffmpegPath);
        cmdParam.add("-i");
        cmdParam.add(sourceFile.getAbsolutePath());
        execCmd(cmdParam);
    }

    /**
     * 
     * ��ȡͼƬ�ĵ�һ֡ ffmpeg commandLine�� ffmpeg -y -i /usr/local/bin/lh.3gp -vframes
     * 1 -r 1 -ac 1 -ab 2 -s 320x240 -f image2 /usr/local/bin/lh.jpg
     * 
     * @param sourceFile
     *            Դ�ļ�
     * @param destination
     *            Ŀ���ļ�
     * @param surfix
     *            Ҫ�����ͼƬ��ʽ��jpg,jpeg,gif
     * @throws IOException
     * @throws IOException
     */
    public/* MRecord */void captureFirstFrame(File sourceFile,
            String destination) {
        // return captureFirstFrame(sourceFile, destination, "jpg");
        captureFirstFrame(sourceFile, destination, "jpg");
    }

    public/* MRecord */void captureFirstFrame(File sourceFile,
            String destination, String surfix) {
        String fileName = sourceFile.getName();
        String surffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!isSurpportedType(surffix))
            throw new RuntimeException("unsurpported file type " + surffix);

        List<String> cmd = new LinkedList<String>();
        cmd.add(ffmpegPath);
        cmd.add("-y");
        cmd.add("-i");
        cmd.add(sourceFile.getAbsolutePath());
        cmd.add("-vframes");
        cmd.add("1");
        cmd.add("-r");
        cmd.add("1");
        cmd.add("-ac");
        cmd.add("1");
        cmd.add("-ab");
        cmd.add("2");
        cmd.add("-s");
        cmd.add("56*56");
        cmd.add("-f");
        cmd.add("image2");
        cmd.add(destination + FILE_SEPARATOR
                + fileName.substring(0, fileName.lastIndexOf(".")) + "."
                + surfix);
        execCmd(cmd);
        // return execCmd(cmd);
    }

    private/* MRecord */void execCmd(List<String> cmd) {
        // MRecord out = null;
        String result = "";
        final ProcessBuilder pb = new ProcessBuilder();
        pb.redirectErrorStream(true);
        pb.command(cmd);
        try {
            final Process proc = pb.start();
            InputStream in = proc.getInputStream();
            // out = pattInfo(in);

            byte[] re = new byte[1024];
            while (in.read(re) != -1) {
                System.out.println(new String(re));
                result = result + new String(re);
            }
            in.close();
            pattInfo(in);
            // �����������߳����������������������⻺�����������߳�����.
            try {
                proc.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            proc.getErrorStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return out;
    }

    // ����ӷ�����Ϣ�ж�ȡ����
    private String read(InputStream is) {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new InputStreamReader(is), 500);

            String line = "";
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                sb.append(line);
            }
            br.close();
        } catch (Exception e) {
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (Exception e) {
            }
        }
        return sb.toString();
    }

    // ����ӷ��ص������н���
    /**
     * Input #0, avi, from 'c:\join.avi': Duration: 00:00:10.68(ʱ��), start:
     * 0.000000(��ʼʱ��), bitrate: 166 kb/s(����) Stream #0:0: Video: msrle
     * ([1][0][0][0] / 0x0001)(�����ʽ), pal8(��Ƶ��ʽ), 165x97(�ֱ���), 33.33 tbr, 33.33
     * tbn, 33.33 tbc Metadata: title : AVI6700.tmp.avi Video #1
     */
    public/* MRecord */void pattInfo(InputStream is) {
        String info = read(is);
        // MRecord out = new MRecord();
        String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
        Pattern pattern = Pattern.compile(regexDuration);
        Matcher m = pattern.matcher(info);
        if (m.find()) {
            System.out.println("timelen" + getTimelen(m.group(1)));

            System.out.println("begintime" + m.group(2));
            System.out.println("kb" + m.group(3) + "kb/s");
        }
        // return out;
    }

    // ��ʽ:"00:00:10.68"
    private int getTimelen(String timelen) {
        int min = 0;
        String strs[] = timelen.split(":");
        if (strs[0].compareTo("0") > 0) {
            min += Integer.valueOf(strs[0]) * 60 * 60;// ��
        }
        if (strs[1].compareTo("0") > 0) {
            min += Integer.valueOf(strs[1]) * 60;
        }
        if (strs[2].compareTo("0") > 0) {
            min += Math.round(Float.valueOf(strs[2]));
        }
        return min;
    }

    public static void main(String[] args) {
        String ffmpegPath = "D:/program/ffmpeg/bin";
        // String ffmpegPath =
        // "E:/04-source/02-opensource/ffmpeg/bin/ffmpeg.exe";
        // File file = new File("c:/join.avi");
        // File file = new File("/root/sunlj/93.mp4");
        File file = new File("E:/bTinghua.mp4");
        // FFMpegUtil.me().init(ffmpegPath).captureFirstFrame(file, "c:/",
        // "jpg");
        FFMpegUtil.me().init(ffmpegPath + "/ffmpeg.exe").getVideoMsg(file);

        // FFMpegUtil.me().init(ffmpegPath).convertToMp4(file, "E:/");
        String t = "00:00:10.68";
        String strs[] = t.split(":");
        int min = 0;
        if (strs[0].compareTo("0") > 0) {
            min += Integer.valueOf(strs[0]) * 60 * 60;// ��
        }
        if (strs[1].compareTo("0") > 0) {
            min += Integer.valueOf(strs[1]) * 60;
        }
        if (strs[2].compareTo("0") > 0) {
            min += Math.round(Float.valueOf(strs[2]));
        }
        // MPrint.print(min);
    }

}
