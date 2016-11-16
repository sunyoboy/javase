package com.javase.net;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class FtpHelper {

	private FTPClient ftp = null;
	/**
	 * Ftp������
	 */
	private String server;
	/**
	 * �û���
	 */
	private String uname;
	/**
	 * ����
	 */
	private String password;
	/**
	 * ���Ӷ˿ڣ�Ĭ��21
	 */
	private int port = 21;
	
	private Document document ;

	public FtpHelper(String server, int port, String uname,
			String password){
		this.server = server;
		if (this.port > 0){
			this.port = port;
		}
		this.uname = uname;
		this.password = password;
		//��ʼ��
		ftp = new FTPClient();	
	}
	/**
	 * ����FTP������
	 * 
	 * @param server
	 * @param uname
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public FTPClient connectFTPServer() throws Exception {
		try {
			ftp.configure(getFTPClientConfig());
			ftp.connect(this.server, this.port);
			if (!ftp.login(this.uname, this.password)) {
				ftp.logout();
				ftp = null;
				return ftp;
			}

			// �ļ�����,Ĭ����ASCII
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.setControlEncoding("GBK");
			// ���ñ���ģʽ
			ftp.enterLocalPassiveMode();
			ftp.setConnectTimeout(2000);
			ftp.setBufferSize(1024);
			// ��Ӧ��Ϣ
			int replyCode = ftp.getReplyCode();
			if ((!FTPReply.isPositiveCompletion(replyCode))) {
				// �ر�Ftp����
				closeFTPClient();
				// �ͷſռ�
				ftp = null;
				throw new Exception("��¼FTP������ʧ��,����![Server:" + server + "��"
						+ "User:" + uname + "��" + "Password:" + password);
			} else {
				return ftp;
			}
		} catch (Exception e) {
			ftp.disconnect();
			ftp = null;
			throw e;
		}
	}

	/**
	 * ����FTP���Ӳ���
	 * 
	 * @return
	 * @throws Exception
	 */
	public FTPClientConfig getFTPClientConfig() throws Exception {
		String systemKey = FTPClientConfig.SYST_NT;
		String serverLanguageCode = "zh";
		FTPClientConfig conf = new FTPClientConfig(systemKey);
		conf.setServerLanguageCode(serverLanguageCode);
		conf.setDefaultDateFormatStr("yyyy-MM-dd");
		return conf;
	}

	/**
	 * ��FTP��Ŀ¼�ϴ��ļ�
	 * 
	 * @param localFile
	 * @param newName
	 *            ���ļ���
	 * @throws Exception
	 */
	public Boolean uploadFile(String localFile, String newName)
			throws Exception {
		InputStream input = null;
		boolean success = false;
		try {
			File file = null;
			if (checkFileExist(localFile)) {
				file = new File(localFile);
			}
			input = new FileInputStream(file);
			success = ftp.storeFile(newName, input);
			if (!success) {
				throw new Exception("�ļ��ϴ�ʧ��!");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}

	/**
	 * ��FTP��Ŀ¼�ϴ��ļ�
	 * 
	 * @param input
	 * @param newName
	 *            ���ļ���
	 * @throws Exception
	 */
	public Boolean uploadFile(InputStream input, String newName)
			throws Exception {
		boolean success = false;
		try {
			success = ftp.storeFile(newName, input);
			if (!success) {
				throw new Exception("�ļ��ϴ�ʧ��!");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}

	/**
	 * ��FTPָ��·���ϴ��ļ�
	 * 
	 * @param localFile
	 * @param newName
	 *            ���ļ���
	 * @param remoteFoldPath
	 * @throws Exception
	 */
	public Boolean uploadFile(String localFile, String newName,
			String remoteFoldPath) throws Exception {

		InputStream input = null;
		boolean success = false;
		try {
			File file = null;
			if (checkFileExist(localFile)) {
				file = new File(localFile);
			}
			input = new FileInputStream(file);

			// �ı䵱ǰ·����ָ��·��
			if (!this.changeDirectory(remoteFoldPath)) {
				System.out.println("������·������!");
				return false;
			}
			success = ftp.storeFile(newName, input);
			if (!success) {
				throw new Exception("�ļ��ϴ�ʧ��!");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}

	/**
	 * ��FTPָ��·���ϴ��ļ�
	 * 
	 * @param input
	 * @param newName
	 *            ���ļ���
	 * @param remoteFoldPath
	 * @throws Exception
	 */
	public Boolean uploadFile(InputStream input, String newName,
			String remoteFoldPath) throws Exception {
		boolean success = false;
		try {
			// �ı䵱ǰ·����ָ��·��
			if (!this.changeDirectory(remoteFoldPath)) {
				System.out.println("������·������!");
				return false;
			}
			success = ftp.storeFile(newName, input);
			if (!success) {
				throw new Exception("�ļ��ϴ�ʧ��!");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return success;
	}

	/**
	 * ��FTP�����������ļ�
	 * 
	 * @param remotePath
	 *            FTP·��(�������ļ���)
	 * @param fileName
	 *            �����ļ���
	 * @param localPath
	 *            ����·��
	 */
	public Boolean downloadFile(String remotePath, String fileName,
			String localPath) throws Exception {

		BufferedOutputStream output = null;
		boolean success = false;
		try {
			// ��鱾��·��
			this.checkFileExist(localPath);
			// �ı乤��·��
			if (!this.changeDirectory(remotePath)) {
				System.out.println("������·��������");
				return false;
			}
			// �г���ǰ����·���µ��ļ��б�
			List<FTPFile> fileList = this.getFileList();
			if (fileList == null || fileList.size() == 0) {
				System.out.println("��������ǰ·���²������ļ���");
				return success;
			}
			for (FTPFile ftpfile : fileList) {
				if (ftpfile.getName().equals(fileName)) {
					File localFilePath = new File(localPath + File.separator
							+ ftpfile.getName());
					output = new BufferedOutputStream(new FileOutputStream(
							localFilePath));
					success = ftp.retrieveFile(ftpfile.getName(), output);
				}
			}
			if (!success) {
				throw new Exception("�ļ�����ʧ��!");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (output != null) {
				output.close();
			}
		}
		return success;
	}

	/**
	 * ��FTP��������ȡ�ļ���
	 * 
	 * @param remoteFilePath
	 * @return
	 * @throws Exception
	 */
	public InputStream downloadFile(String remoteFilePath) throws Exception {

		return ftp.retrieveFileStream(remoteFilePath);
	}

	/**
	 * ��ȡFTP��������ָ��·���µ��ļ��б�
	 * 
	 * @param filePath
	 * @return
	 */
	public List<FTPFile> getFtpServerFileList(String remotePath)
			throws Exception {

		FTPListParseEngine engine = ftp.initiateListParsing(remotePath);
		List<FTPFile> ftpfiles = Arrays.asList(engine.getNext(25));

		return ftpfiles;
	}

	/**
	 * ��ȡFTP��������[ָ��·��]�µ��ļ��б�
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<FTPFile> getFileList(String remotePath) throws Exception {

		List<FTPFile> ftpfiles = Arrays.asList(ftp.listFiles(remotePath));

		return ftpfiles;
	}

	/**
	 * ��ȡFTP������[��ǰ����·��]�µ��ļ��б�
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<FTPFile> getFileList() throws Exception {

		List<FTPFile> ftpfiles = Arrays.asList(ftp.listFiles());

		return ftpfiles;
	}

	/**
	 * �ı�FTP����������·�� 
	 * 
	 * @param remoteFoldPath
	 */
	public Boolean changeDirectory(String remoteFoldPath) throws Exception {

		return ftp.changeWorkingDirectory(remoteFoldPath);
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param remoteFilePath
	 * @return
	 * @throws Exception
	 */
	public Boolean deleteFtpServerFile(String remoteFilePath) throws Exception {

		return ftp.deleteFile(remoteFilePath);
	}

	/**
	 * ����Ŀ¼
	 * 
	 * @param remoteFoldPath
	 * @return
	 */
	public boolean createFold(String remoteFoldPath) throws Exception {

		boolean flag = ftp.makeDirectory(remoteFoldPath);
		if (!flag) {
			throw new Exception("����Ŀ¼ʧ��");
		}
		return false;
	}

	/**
	 * ɾ��Ŀ¼
	 * @param remoteFoldPath
	 * @return
	 * @throws Exception
	 */
	public boolean deleteFold(String remoteFoldPath) throws Exception {
		
		return ftp.removeDirectory(remoteFoldPath) ;
	}

	/**
	 * ɾ��Ŀ¼�Լ��ļ�
	 * 
	 * @param remoteFoldPath
	 * @return
	 */
	public boolean deleteFoldAndsubFiles(String remoteFoldPath)
			throws Exception {

		boolean success = false;
		List<FTPFile> list = this.getFileList(remoteFoldPath);
		if (list == null || list.size() == 0) {
			return deleteFold(remoteFoldPath);
		}
		for (FTPFile ftpFile : list) {
			
			String name = ftpFile.getName();
			if (ftpFile.isDirectory()) {
				success = deleteFoldAndsubFiles(remoteFoldPath + "/" + name);
				if (!success)
					break;
			} else {
				success = deleteFtpServerFile(remoteFoldPath + "/" + name);
				if (!success)
					break;
			}
		}
		if (!success)
			return false;
		success = deleteFold(remoteFoldPath);
		return success;
	}

	/**
	 * ��鱾��·���Ƿ����
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public boolean checkFileExist(String filePath) throws Exception {
		boolean flag = false;
		File file = new File(filePath);
		if (!file.exists()) {
			throw new Exception("����·��������,����!");
		} else {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * ����XML�ļ�
	 * @return
	 */
	public Element getCurrentElement(){
		document = DocumentHelper.createDocument();
		return document.addElement("root");
	}
	
	/**
	 * ����Ŀ¼XML�ļ�
	 */
	public void createDirectoryXML(String remotePath,Element fatherElement) throws Exception{

		List<FTPFile> list = this.getFileList();
		for(FTPFile ftpfile:list){
			Element currentElement = fatherElement; //��ǰ��Ŀ¼�ڵ�
			String newRemotePath = remotePath+ftpfile.getName();
			if(ftpfile.isDirectory()){
				Element dirElement = fatherElement.addElement("dir") ;
				dirElement.addAttribute("name",ftpfile.getName());
				currentElement = dirElement;
				this.changeDirectory(newRemotePath); //�Ӹ�Ŀ¼��ʼ
				createDirectoryXML(newRemotePath,dirElement);
			}else{
				 Element fileElement = fatherElement.addElement("file");//�ļ��ڵ�
				 fileElement.setText(ftpfile.getName()) ;
			}
		}
	}
	
	/**
	 * ����xml
	 */
	public void saveXML(){
		XMLWriter output = new XMLWriter();
        //�����ʽ��
        OutputFormat format = OutputFormat.createPrettyPrint();
        try {
            output = new XMLWriter(new FileWriter("src/com/shine/Ftp/config/dir.xml"), format);
            output.write(this.document);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * �ر�FTP����
	 * 
	 * @param ftp
	 * @throws Exception
	 */
	public void closeFTPClient(FTPClient ftp) throws Exception {

		try {
			if (ftp.isConnected())
				ftp.logout();
				ftp.disconnect();
		} catch (Exception e) {
			throw new Exception("�ر�FTP�������!");
		}
	}

	/**
	 * �ر�FTP����
	 * 
	 * @throws Exception
	 */
	public void closeFTPClient() throws Exception {

		this.closeFTPClient(this.ftp);
	}

	/**
	 * Get Attribute Method
	 * 
	 */
	public FTPClient getFtp() {
		return ftp;
	}

	public String getServer() {
		return server;
	}

	public String getUname() {
		return uname;
	}

	public String getPassword() {
		return password;
	}

	public int getPort() {
		return port;
	}

	/**
	 * Set Attribute Method
	 * 
	 */
	public void setFtp(FTPClient ftp) {
		this.ftp = ftp;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * ������(����)
	 * 
	 * ���⣺�ϴ�ʱ���������ļ������������ģ������ϴ�ʧ��.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FtpHelper fu = new FtpHelper("192.168.2.18", 21, "administrator","sunshine");
			fu.connectFTPServer();
			Element fatherElement = fu.getCurrentElement();
			fu.createDirectoryXML("/", fatherElement);
			fu.saveXML();
		} catch (Exception e) {
			System.out.println("�쳣��Ϣ��" + e.getMessage());
		}
	}
}
