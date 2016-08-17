package customer;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bankaccount.BankAccountDAO;
import bankaccount.BankAccountDTO;
import bankaccount.BankAccountImp;

import com.sun.xml.internal.ws.resources.HttpserverMessages;

import db.DatabaseManager;

public class CustomerBO
{
	
ServletContext context;
	
	//entry point
	
	public ServletContext getContext() {
		return context;
	}
	public void setContext(ServletContext context) {
		this.context = context;
	}
	public String addCustomer(HttpServletRequest request)
	{
		CustomerForm cForm=uploadImageReturnForm(request);
		//form to dto
		//insert of imp
		Connection con=getConnection();
		
		CustomerDAO cDao=new CustomerImp(con);
		CustomerDTO cDto=formTOdto(cForm);
		String result=cDao.createCustomer(cDto);
		return result;
		
	}
	
	public Connection getConnection(){
		String dburl=(String)context.getAttribute("dburl");
		String dbuname=(String)context.getAttribute("dbuname");
		String dbpassword=(String)context.getAttribute("dbpassword");
		Connection con=DatabaseManager.getConnection(dburl, dbuname, dbpassword);
		return con;
		
	}
	private CustomerDTO formTOdto(CustomerForm cForm) 
	{
		java.sql.Date dob=convertDate(cForm.getDd(), cForm.getMm(), cForm.getYy());
		// TODO Auto-generated method stub
		//CustomerDTO c=new CustomerDTO(fName, lName, email, street, city, doB, picture, phone, zip)
		CustomerDTO cDTO=new CustomerDTO(cForm.getFname(),cForm.getLname(),cForm.getEmail(),cForm.getStreet(),cForm.getCity() , dob, cForm.getPicture(), Long.parseLong(cForm.getPhone()), Long.parseLong(cForm.getZip()));
		//CustomerDTO cDTO=new CustomerDTO(cForm.getFname(),cForm.getLname(),cForm.getEmail(),cForm.getStreet(),cForm.getCity(),Long.parseLong(cForm.getZip()),cForm.getPhone());
		return cDTO;
		
	}
	public CustomerForm uploadImageReturnForm(HttpServletRequest request)
	{
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		CustomerForm cform=new CustomerForm();
		try
		{
			List<FileItem> items = upload.parseRequest(request);
			Iterator ir=items.iterator();
			while(ir.hasNext())
			{
				FileItem fitem=(FileItem)ir.next();
				if(fitem.isFormField())
				{
					//is a textbox
					String fieldname=fitem.getFieldName();
					String fieldvalue=fitem.getString();
					if(fieldname.equals("fname")){
						cform.setFname(fieldvalue);
					}
					if(fieldname.equals("lname")){
						cform.setLname(fieldvalue);
					}
					if(fieldname.equals("street")){
						cform.setStreet(fieldvalue);
					}
					if(fieldname.equals("city")){
						cform.setCity(fieldvalue);
					}
					if(fieldname.equals("zip")){
						cform.setZip(fieldvalue);
					}
					if(fieldname.equals("email")){
						cform.setEmail(fieldvalue);
					}
					if(fieldname.equals("phone")){
						cform.setPhone(fieldvalue);
					}
					if(fieldname.equals("picture")){
						cform.setPicture(fieldvalue);
					}
					if(fieldname.equals("dd")){
						cform.setDd(fieldvalue);
					}
					if(fieldname.equals("mm")){
						cform.setMm(fieldvalue);
					}
					if(fieldname.equals("yy")){
						cform.setYy(fieldvalue);
					}
					
					
				}
				else
				{
					//is a file
					String fieldname=fitem.getFieldName();
					String imagename=fitem.getName();
					System.out.println("Image name is ........"+imagename);
					String fName=imagename;
					if(imagename.lastIndexOf('\\')!=-1)
					{
						fName=imagename.substring(imagename.lastIndexOf('\\'),imagename.length());
					}
					System.out.println("Testing image name        "+fName);
					if(fieldname.equals("picture1")){
						cform.setPicture(fName);
					}
					String imagelocation=(String)context.getAttribute("imagelocation");
					String filename_path=imagelocation+fName;
					File f=new File(filename_path);
					try {
						fitem.write(f);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		} 
		catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cform;
	}
	//this function will help to convert from String dd mm yy to java.sql.Date
	public java.sql.Date convertDate(String dd,String mm, String yy)
	{
		java.sql.Date dob=null;
		String pattern="dd/MM/yyyy";
		String d1=dd+"/"+mm+"/"+yy;
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		try {
			java.util.Date d2=sdf.parse(d1);
			dob=new Date(d2.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dob;
	}
	
}
