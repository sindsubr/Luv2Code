package org.springmvcdb.crm.utils;

import org.hibernate.dialect.InnoDBStorageEngine;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.MySQLStorageEngine;

/**
 * For innodb engine settings and foreign key 
 * @author sindu
 *
 */
public class MySQL55Dialect extends MySQL5Dialect {

    @Override
    protected MySQLStorageEngine getDefaultMySQLStorageEngine() {
            return InnoDBStorageEngine.INSTANCE;
    }
}
