package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner{

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        Customer freddyMeyers = new Customer();
        freddyMeyers.setFirstname("Freddy");
        freddyMeyers.setLastname("Meyers");

        Customer johnNewman = new Customer();
        johnNewman.setFirstname("John");
        johnNewman.setLastname("Newman");

        Customer marcelMocan = new Customer();
        marcelMocan.setFirstname("Marcel");
        marcelMocan.setLastname("Mocan");

        Customer andreiPop = new Customer();
        andreiPop.setFirstname("Andrei");
        andreiPop.setLastname("Pop");

        customerRepository.save(freddyMeyers);
        customerRepository.save(johnNewman);
        customerRepository.save(marcelMocan);
        customerRepository.save(andreiPop);

        System.out.println("Categories Loaded = " + categoryRepository.count());
        System.out.println("Customers Loaded = " + customerRepository.count());
    }
}
