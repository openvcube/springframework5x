package org.springframework.samples.jca.standalone;

import java.sql.SQLException;

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResultSet;

import org.springframework.jca.cci.object.MappingRecordOperation;
import org.springframework.samples.jca.model.Person;

import com.sun.connector.cciblackbox.CciInteractionSpec;

public class PersonMappingOperation extends MappingRecordOperation {

	public PersonMappingOperation(ConnectionFactory connectionFactory) {
		setConnectionFactory(connectionFactory);
		CciInteractionSpec interactionSpec = new CciInteractionSpec();
		interactionSpec.setSql("select * from person where person_id=?");
		setInteractionSpec(interactionSpec);
	}

	protected Record createInputRecord(RecordFactory recordFactory,
			Object inputObject) throws ResourceException {
		Integer id = (Integer) inputObject;
		IndexedRecord input = recordFactory.createIndexedRecord("input");
		input.add(new Integer(id));
		return input;
	}

	protected Object extractOutputData(Record outputRecord)
			throws ResourceException, SQLException {
		ResultSet rs = (ResultSet) outputRecord;
		Person person = null;
		if (rs.next()) {
			person = new Person();
			person.setId(rs.getInt("person_id"));
			person.setLastName(rs.getString("person_last_name"));
			person.setFirstName(rs.getString("person_first_name"));
		}
		return person;
	}

}
