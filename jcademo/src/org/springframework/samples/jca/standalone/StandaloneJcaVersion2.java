/*
 * Copyright 2002-2004 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 

package org.springframework.samples.jca.standalone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.jca.model.Person;
import org.springframework.samples.jca.service.PersonService;

/**
 * 
 * @author worldheart
 *
 */
public class StandaloneJcaVersion2 {

	private final PersonService service;

	private static final Log log = LogFactory.getLog(StandaloneJcaVersion2.class);

	public StandaloneJcaVersion2(PersonService service) {
		this.service = service;
	}

	public void execute(int id) {
		try {
			Person person=service.getPersonVersion2(id);
			log.info("firstname = " + person.getFirstName());
			log.info("lastname = " + person.getLastName());
		} catch(Exception ex) {
			log.error("",ex);
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("/cci.xml");
		PersonService service = (PersonService) context.getBean("personService");
		StandaloneJcaVersion2 tool = new StandaloneJcaVersion2(service);
		tool.execute(1);
	}

}
