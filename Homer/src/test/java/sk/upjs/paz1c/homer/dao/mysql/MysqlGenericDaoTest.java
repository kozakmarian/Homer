/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.paz1c.homer.dao.mysql;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.homer.ObjectFactory;
import sk.upjs.paz1c.homer.entity.Entity;

/**
 *
 * @author ntb
 */
public class MysqlGenericDaoTest {
    
    

    public MysqlGenericDaoTest() {
    }
    
   
    @Test
    public void testDelete() {
        System.out.println("delete");
        Entity entity = null;
        MysqlGenericDao instance = null;
        instance.delete(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class MysqlGenericDao.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Long id = null;
        MysqlGenericDao instance = null;
        Entity expResult = null;
        Entity result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class MysqlGenericDao.
     */
    @Test
    public void testList() {
        System.out.println("list");
        MysqlGenericDao instance = null;
        List expResult = null;
        List result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of store method, of class MysqlGenericDao.
     */
    @Test
    public void testStore() {
        System.out.println("store");
        Entity entity = null;
        MysqlGenericDao instance = null;
        instance.store(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MysqlGenericDaoImpl extends MysqlGenericDao {

        public MysqlGenericDaoImpl() {
            super(null, null, "");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.paz1c.homer.dao.mysql;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.homer.entity.Entity;

/**
 *
 * @author dyske
 */
public class MysqlGenericDaoTest {
    
    public MysqlGenericDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of delete method, of class MysqlGenericDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Entity entity = null;
        MysqlGenericDao instance = null;
        instance.delete(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class MysqlGenericDao.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Long id = null;
        MysqlGenericDao instance = null;
        Entity expResult = null;
        Entity result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class MysqlGenericDao.
     */
    @Test
    public void testList() {
        System.out.println("list");
        MysqlGenericDao instance = null;
        List expResult = null;
        List result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of store method, of class MysqlGenericDao.
     */
    @Test
    public void testStore() {
        System.out.println("store");
        Entity entity = null;
        MysqlGenericDao instance = null;
        instance.store(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MysqlGenericDaoImpl extends MysqlGenericDao {

        public MysqlGenericDaoImpl() {
            super(null, null, "");
        }
    }
    
}
