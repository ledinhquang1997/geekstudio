package com.codingmanstudio.courses.bootstrap;

import com.codingmanstudio.courses.domain.Category;
import com.codingmanstudio.courses.domain.Instructor;
import com.codingmanstudio.courses.repository.AccountRepository;
import com.codingmanstudio.courses.repository.CategoryRepository;
import com.codingmanstudio.courses.repository.RoleRepository;
import com.codingmanstudio.courses.Utils.EncrytedPasswordUtils;
import com.codingmanstudio.courses.domain.Role;
import com.codingmanstudio.courses.domain.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;
    public DataLoader(RoleRepository roleRepository, AccountRepository accountRepository, CategoryRepository categoryRepository) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count()==0) {
            Role role_user = new Role();
            role_user.setRole("ROLE_USER");
            Role saved_role_user = roleRepository.save(role_user);

            Role role_learner = new Role();
            role_learner.setRole("ROLE_LEARNER");
            Role saved_role_learner = roleRepository.save(role_learner);

            Role role_admin = new Role();
            role_admin.setRole("ROLE_ADMIN");
            Role saved_role_admin = roleRepository.save(role_admin);

            Account user1 = new Account();
            user1.setUsername("quang");
            user1.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            System.out.println(user1.getEncrytedPassword());
            user1.getRoles().add(saved_role_admin);
            user1.getRoles().add(saved_role_user);
            accountRepository.save(user1);

            Account user2 = new Account();
            user2.setUsername("thang");
            user2.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            user2.getRoles().add(saved_role_learner);
            accountRepository.save(user2);

            Account user3 = new Account();
            user3.setUsername("hai");
            user3.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
            accountRepository.save(user3);


            Category cat1 = new Category();
            cat1.setName("Programming");
            cat1.setDescription("That’s all you have to do to let Hibernate generate UUIDs as primary key values. You can see an example of it in the following code snippet");
            Category savedcat1= categoryRepository.save(cat1);

            Category cat2 = new Category();
            cat2.setName("Business");
            cat2.setDescription("That’s all you have to do to let Hibernate generate UUIDs as primary key values. You can see an example of it in the following code snippet");
            Category savedcat2= categoryRepository.save(cat2);


            Instructor alex = new Instructor();
            alex.setName("Alex Jefferson");
            alex.setEmail("alex@gmail.com");
            alex.setCompany("FPT");


            System.out.println(savedcat1.getId().toString());
        }



    }

}
