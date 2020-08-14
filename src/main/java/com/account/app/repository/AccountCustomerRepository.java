package com.account.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.account.app.entity.AccountCustomer;
import com.account.app.entity.AccountCustomerId;


@Repository
public interface AccountCustomerRepository extends JpaRepository<AccountCustomer, AccountCustomerId> {

	@Query(value="SELECT a.id,a.account_name,at.account_type FROM ACCOUNT_CUSTOMER ac ,ACCOUNT  a ,account_type at where ac.account_id=a.id and ac.customer_id=:id and at.id=a.account_type;",nativeQuery=true)
	List<Object[]> findByCustomerId(@Param("id")Integer id);
}
