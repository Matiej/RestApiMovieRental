package pl.testaarosa.movierental.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.testaarosa.movierental.domain.Role;
import pl.testaarosa.movierental.repositories.MockRole;
import pl.testaarosa.movierental.repositories.RoleRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTestSuit {

    private MockRole mockRole = new MockRole();

    @InjectMocks
    private RoleServiceImpl roleServicee;

    @Mock
    private RoleRepository roleRepository;

    @Test
    public void testFindByName() {
        //given
        Role role = mockRole.getRole();
        when(roleRepository.findByName("USER")).thenReturn(role);
        //when
        Role result = roleServicee.findByName("USER");
        Role expect = mockRole.getRole();
        //then
        assertEquals(expect,result);
    }
}
