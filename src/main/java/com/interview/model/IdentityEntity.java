/*
 * This class/interface has been created by Leonardo Pavone for a test project
 * to technical interview with Brandtone.
 */
package com.interview.model;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
* Abstract class only contain the ID common for all classes mapped on a
* table.
* 
* @author Leonardo Pavone
*/
@MappedSuperclass
public abstract class IdentityEntity extends BaseObject implements Serializable {

        protected Long id;

        /**
         * Default constructor, instantiates class instance
         */
        public IdentityEntity() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
}
