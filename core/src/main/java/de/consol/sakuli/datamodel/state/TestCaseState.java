/*
 * Sakuli - Testing and Monitoring-Tool for Websites and common UIs.
 *
 * Copyright 2013 - 2014 the original author or authors.
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

package de.consol.sakuli.datamodel.state;

import java.util.Arrays;
import java.util.List;

/**
 * Enum which represents the Sahi-Case-Stati in file "sahi_return_codes"
 *
 * @author tschneck
 *         Date: 21.06.13
 */
public enum TestCaseState implements SakuliState {
    /**
     * value = 0
     */
    OK(0, "ok"),

    /**
     * value = 1
     */
    WARNING_IN_STEP(1, "warning in step"),

    /**
     * value = 2
     */
    WARNING(2, "warning"),

    /**
     * value = 3
     */
    CRITICAL(3, "critical"),

    /**
     * value = 4
     */
    ERRORS(4, "EXCEPTION");
    private final int errorCode;
    private final String stateDescription;

    private TestCaseState(int i, String stateDescription) {
        this.errorCode = i;
        this.stateDescription = stateDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public int getNagiosErrorCode() {
        if (getOkCodes().contains(this)) {
            return 0;
        } else if (getWarningCodes().contains(this)) {
            return 1;
        } else if (getCriticalCodes().contains(this)) {
            return 2;
        }
        return 3;
    }

    @Override
    public String getNagiosStateDescription() {
        return stateDescription;
    }


    public List<TestCaseState> getWarningCodes() {
        return Arrays.asList(WARNING, WARNING_IN_STEP);
    }

    public List<TestCaseState> getOkCodes() {
        return Arrays.asList(OK);
    }

    public List<TestCaseState> getCriticalCodes() {
        return Arrays.asList(CRITICAL, ERRORS);
    }

}