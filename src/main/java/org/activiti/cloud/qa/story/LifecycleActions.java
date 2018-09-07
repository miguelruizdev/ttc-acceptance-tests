/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.qa.story;

import net.thucydides.core.annotations.Steps;
import org.activiti.cloud.qa.steps.*;
import org.jbehave.core.annotations.BeforeStories;

/**
 * Lifecycle steps
 */
public class LifecycleActions {

    @Steps
    private AuthenticationSteps authenticationSteps;

    @Steps
    private TweeterSteps tweeterSteps;

    @Steps
    private TTCRuntimeBundleSteps runtimeBundleSteps;

    @Steps
    private QueryCampaignSteps queryCampaignSteps;

    @Steps
    private CloudGatewaySteps cloudGatewaySteps;

    @Steps
    private ProcessingSteps processingSteps;

    @Steps
    private RewardSteps rewardSteps;

    @Steps
    private RankingSteps rankingSteps;

    @BeforeStories
    public void checkServicesHealth() {
        authenticationSteps.authenticateTestUser();
        runtimeBundleSteps.checkServicesHealth();
        tweeterSteps.checkServicesHealth();
        queryCampaignSteps.checkServicesHealth();
        cloudGatewaySteps.checkServicesHealth();
        cloudGatewaySteps.refresh();
        processingSteps.checkServicesHealth();
        rewardSteps.checkServicesHealth();
        rankingSteps.checkServicesHealth();
    }

}
