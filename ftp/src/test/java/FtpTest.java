import org.junit.Test;
import sun.net.ftp.FtpClient;

import static org.junit.Assert.*;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>PACKAGE_NAME</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2018/1/9 14:46:53
 * @Version v1.0
 */
public class FtpTest {

    @Test
    public void testReadFtpFile(){
        FtpClient ftp = Ftp.connectFTP("10.10.20.200", 21, "Z003Trans", "000000");
        assertNotNull(ftp);
        String result = Ftp.readFtpFile("/20180109/haruhi.txt", ftp);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void testDownloadFtpFile(){
        FtpClient ftp = Ftp.connectFTP("10.10.20.200", 21, "Z003Trans", "000000");
        assertNotNull(ftp);
        Ftp.download("S://Nagato/nagato.txt", "/20180109/haruhi.txt", ftp);
    }
}