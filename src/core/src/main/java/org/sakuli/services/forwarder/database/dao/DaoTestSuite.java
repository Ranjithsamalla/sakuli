/*
 * Sakuli - Testing and Monitoring-Tool for Websites and common UIs.
 *
 * Copyright 2013 - 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sakuli.services.forwarder.database.dao;

import org.sakuli.services.forwarder.database.ProfileJdbcDb;

/**
 * @author tschneck
 *         Date: 17.06.13
 */
@ProfileJdbcDb
public interface DaoTestSuite {


    /**
     * save the initial TestSuite data into the table sakuli_suites and returns the valid primary key from the database
     *
     * @return database id (primary key) for this suite
     */
    int insertInitialTestSuiteData();

    void saveTestSuiteResult();

    int saveTestSuiteToSahiJobs();

    int getCountOfSahiJobs();
}
