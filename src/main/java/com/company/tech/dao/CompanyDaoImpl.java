/*
 * Created by Sachith Tharaka 
 */

package com.company.tech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.company.tech.domain.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao{

	@PersistenceContext
	EntityManager em;
	
	/*
	 * This class interact with our database.
	 * EntityManager helps to handle queries and We used criteria query
	 */
	
	@Override
	public Company addNewCompany(Company company) {
		try {
			em.persist(company);
			return company;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Company findCompanyByName(String companyName) {
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Company> query = cb.createQuery(Company.class);
			Root<Company> root = query.from(Company.class);
			
			query.select(root).where(cb.equal(root.get("name") , companyName));
			return em.createQuery(query).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Company updateCompany(Company company) {
		
		try{
			em.merge(company);
			return company;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Company findCompanyById(int id) {
		
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Company> query = cb.createQuery(Company.class);
			Root<Company> root = query.from(Company.class);
			
			query.select(root).where(cb.equal(root.get("id") , id));
			return em.createQuery(query).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Company> getCompanies() {
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Company> query = cb.createQuery(Company.class);
			Root<Company> root = query.from(Company.class);
			
			query.select(root);
			return em.createQuery(query).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Company> getInactiveCompanies() {

		try{
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Company> query = cb.createQuery(Company.class);
			Root<Company> root = query.from(Company.class);
			
			query.select(root).where(cb.equal(root.get("status"), "INACTIVE"));
			return em.createQuery(query).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
