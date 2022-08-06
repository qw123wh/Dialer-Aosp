/*
 * Copyright (C) 2018 The Android Open Source Project
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
 * limitations under the License
 */

package com.fissy.dialer.activecalls;

import com.fissy.dialer.activecalls.impl.ActiveCallsImpl;
import com.fissy.dialer.inject.DialerVariant;
import com.fissy.dialer.inject.InstallIn;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Module for {@link ActiveCallsComponent}
 */
@Module
@InstallIn(variants = DialerVariant.DIALER_TEST) // TODO(weijiaxu): put all variants.
public abstract class ActiveCallsModule {

    @Singleton
    @Binds
    public abstract ActiveCalls to(ActiveCallsImpl impl);
}
