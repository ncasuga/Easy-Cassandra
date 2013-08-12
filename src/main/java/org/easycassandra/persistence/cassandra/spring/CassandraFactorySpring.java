/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.easycassandra.persistence.cassandra.spring;

import org.easycassandra.persistence.cassandra.CassandraFactory;

/**
 * base create Connection of Cassandra Template
 * @author otaviojava
 *
 */
public interface CassandraFactorySpring extends CassandraFactory{
	
	
	/**
	 * returns template using host in the parameter and default keyspace
	 * @param host
	 * @return the Cassandra Template {@link CassandraTemplate}
	 */
	CassandraTemplate getTemplate(String host);

	/**
	 * returns the template of cassandra using host and keyspace in the parameters
	 * @param host
	 * @param keySpace
	 * @return the Cassandra Template {@link CassandraTemplate}
	 */
	CassandraTemplate getTemplate(String host, String keySpace);
	
	/**
	 * returns the template of cassandra using host and keyspace in the parameters
	 * @param host
	 * @param keySpace
	 * @param port
	 * @return
	 */
	CassandraTemplate getTemplate(String host, String keySpace,int port);
	
	/**
	 * returns template using values default
	 * @return the Cassandra Template {@link CassandraTemplate}
	 */
	CassandraTemplate getTemplate();
	

}
