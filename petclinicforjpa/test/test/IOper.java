package test;

import java.util.Collection;

import test.entityjpa.Owners;

/**
 * 
 * @author worldheart
 *
 */
public interface IOper {

	public void testOper();
	
	public void storeOwnerSave(Owners owner);
	
	public Collection findOwners(String lastName);
	
}
