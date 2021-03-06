package org.drools.guvnor.client.packages;
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



import junit.framework.TestCase;

import org.drools.guvnor.client.modeldriven.SuggestionCompletionEngine;
import org.drools.guvnor.client.packages.SuggestionCompletionCache;

import com.google.gwt.user.client.Command;

public class SuggestionCompletionCacheTest extends TestCase {

    private boolean executed;
    private boolean loaded;

    protected void setUp() throws Exception {
        super.setUp();
        executed = false;
        loaded = false;
    }

    public void testCache() {
        SuggestionCompletionCache cache1 = SuggestionCompletionCache.getInstance();
        assertSame(cache1, SuggestionCompletionCache.getInstance());

        final SuggestionCompletionCache cache = new SuggestionCompletionCache() {

            public void loadPackage(String packageName,
                             Command command) {
                loaded = true;

            }
        };

        cache.doAction( "xyz", new Command() {
            public void execute() {
            }
        });
        assertTrue (loaded);
        SuggestionCompletionEngine eng = new SuggestionCompletionEngine();
        cache.cache.put( "foo",  eng);

        cache.doAction( "foo", new Command() {

            public void execute() {
                executed = true;
            }

        });

        assertTrue(executed);

        assertNotNull(cache.getEngineFromCache( "foo" ));

        cache.refreshPackage( "foo", new Command() {

            public void execute() {

            }

        });




    }

}