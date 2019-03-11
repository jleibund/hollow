/*
 *  Copyright 2016-2019 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.hollow.api.objects.generic;

import com.netflix.hollow.api.objects.HollowList;
import com.netflix.hollow.api.objects.HollowRecord;
import com.netflix.hollow.api.objects.delegate.HollowListDelegate;
import com.netflix.hollow.api.objects.delegate.HollowListLookupDelegate;
import com.netflix.hollow.core.read.dataaccess.HollowDataAccess;
import com.netflix.hollow.core.read.dataaccess.HollowListTypeDataAccess;
import com.netflix.hollow.tools.stringifier.HollowRecordStringifier;

/**
 * This is a generic handle to a LIST type record. 
 * 
 * The Generic Hollow Object API can be used to programmatically inspect a dataset (referenced by a {@link HollowDataAccess})
 * without a custom-generated API. 
 */
public class GenericHollowList extends HollowList<HollowRecord> {
    
    public GenericHollowList(HollowDataAccess dataAccess, String type, int ordinal) {
        this((HollowListTypeDataAccess)dataAccess.getTypeDataAccess(type, ordinal), ordinal);
    }

    public GenericHollowList(HollowListTypeDataAccess dataAccess, int ordinal) {
        this(new HollowListLookupDelegate<HollowRecord>(dataAccess), ordinal);
    }

    public GenericHollowList(HollowListDelegate<HollowRecord> delegate, int ordinal) {
        super(delegate, ordinal);
    }
    
    public GenericHollowObject getObject(int idx) {
        return (GenericHollowObject)get(idx);
    }
    
    public Iterable<GenericHollowObject> objects() {
        return new GenericHollowIterable<GenericHollowObject>(this);
    }
    
    public Iterable<GenericHollowList> lists() {
        return new GenericHollowIterable<GenericHollowList>(this);
    }
    
    public Iterable<GenericHollowSet> sets() {
        return new GenericHollowIterable<GenericHollowSet>(this);
    }
    
    public Iterable<GenericHollowMap> maps() {
        return new GenericHollowIterable<GenericHollowMap>(this);
    }
    
    @Override
    public HollowRecord instantiateElement(int elementOrdinal) {
        return GenericHollowRecordHelper.instantiate(getTypeDataAccess().getDataAccess(), getSchema().getElementType(), elementOrdinal);
    }

    @Override
    public boolean equalsElement(int elementOrdinal, Object testObject) {
        return GenericHollowRecordHelper.equalObject(getSchema().getElementType(), elementOrdinal, testObject);
    }
    
    @Override
    public String toString() {
        return new HollowRecordStringifier().stringify(this);
    }
    
}
