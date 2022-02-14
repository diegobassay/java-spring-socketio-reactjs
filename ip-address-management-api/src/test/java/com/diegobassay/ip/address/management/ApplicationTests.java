package com.diegobassay.ip.address.management;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.diegobassay.ip.address.management.Application;

@SpringBootTest
class ApplicationTests {

   @Test
   void main() {
      Application.main(new String[] {});
   }

}