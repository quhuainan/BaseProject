/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com>
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
 *
 */
package com.qhn.bhne.xhmusic.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 咖枯
 * @version 1.0 2016/8/20
 */
public class TransformUtils {
    public static <T> Observable.Transformer<T, T> defaultSchedulers() {
        return new Observable.Transformer<T, T>() {

            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .unsubscribeOn(Schedulers.io())//?不明白什么意思取消以后为什么又要在子线程订阅呢？
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}