package org.drools.guvnor.server.repository;
/*
 * Copyright 2005 JBoss Inc
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



import org.drools.guvnor.server.repository.BRMSRepositoryConfiguration;
import org.drools.guvnor.server.repository.RulesRepositoryManager;

import junit.framework.TestCase;

public class RulesRepositoryManagerTest extends TestCase {
	public void test1() {
		// added this so we don't get a failer for now tests
	}

	// FIXME
    public void FIXME_testDecorator() {
        RulesRepositoryManager dec = new RulesRepositoryManager();
        BRMSRepositoryConfiguration config = new BRMSRepositoryConfiguration();
        MockRepo repo = new MockRepo();
        config.repository = repo;
        dec.repositoryConfiguration = config;

        dec.create();
        
        assertNotNull(dec.getRepository().getSession());
        
        
        assertFalse(repo.session.loggedout);
        dec.close();
        assertTrue(repo.session.loggedout);
        
        
    }
    
    
}