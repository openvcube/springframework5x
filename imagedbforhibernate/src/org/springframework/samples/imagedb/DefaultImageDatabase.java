package org.springframework.samples.imagedb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.util.FileCopyUtils;

/**
 * 
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class DefaultImageDatabase extends HibernateDaoSupport implements ImageDatabase {

	private static final Log log = LogFactory.getLog(DefaultImageDatabase.class);
	
	public List getImages() throws DataAccessException {
		List<ImageDescriptor> returnList = new ArrayList<ImageDescriptor>();
		
		List list = this.getHibernateTemplate().find("from Imagedb");				
		for(Object imagedb: list){
			Imagedb image = (Imagedb)imagedb;
			returnList.add(new ImageDescriptor(image.getImageName(), image.getDescription()));
		}
		
		return returnList;		
	}

	public void streamImage(final String name, final OutputStream contentStream) throws DataAccessException {

		Imagedb imagedb = (Imagedb)this.getHibernateTemplate().get(Imagedb.class, name);
		
		if(imagedb.getContent() != null){
			try{
				FileCopyUtils.copy(imagedb.getContent(), contentStream);
			} catch(IOException io){
				log.error("", io);
			}
		}
		
	}

	public void storeImage(
	    final String name, final InputStream contentStream, final int contentLength, final String description)
	    throws DataAccessException {
		Imagedb imagedb = new Imagedb();
		imagedb.setImageName(name);

		try{
			imagedb.setContent(FileCopyUtils.copyToByteArray(contentStream));
			
		} catch(IOException io){
			log.error("", io);
		}
		
		imagedb.setDescription(description);
		
		this.getHibernateTemplate().saveOrUpdate(imagedb);
	}

	public void checkImages() {
		logger.info("Checking images: not implemented but invoked by scheduling");
	}

	public void clearDatabase() throws DataAccessException {
		this.getHibernateTemplate().bulkUpdate("delete from Imagedb");
	}

}
