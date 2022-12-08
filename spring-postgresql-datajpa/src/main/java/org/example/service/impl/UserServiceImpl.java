package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.entitiy.Address;
import org.example.entitiy.User;
import org.example.repo.AdresRepository;
import org.example.repo.KisiRepository;
import org.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class  UserServiceImpl implements UserService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userdto) {

        User user = new User();
        user.setName(userdto.getName());
        user.setLastName(userdto.getLastName());
        final User userdb = kisiRepository.save(user);
        List<Address> addressList = new ArrayList<>();
        userdto.getAdresler().forEach(adres -> {
            Address address = new Address();
            address.setAdres(adres);
            address.setAdresTip(Address.AdresTip.DIGER);
            address.setActive(true);
            address.setUser(userdb);
            addressList.add(address);
        });
        adresRepository.saveAll(addressList);
        userdb.setId(userdb.getId());
        return userdto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> kisiler = kisiRepository.findAll();
        List<UserDto> kisilerdto = new ArrayList<>();
        kisiler.forEach(it -> {
            UserDto userDto = new UserDto();
            userDto.setName(it.getName());
            userDto.setId(it.getId());
            userDto.setLastName(it.getLastName());
            userDto.setAdresler(it.getAdresler().stream().map(Address::getAdres).collect(Collectors.toList()));
            kisilerdto.add(userDto);
        });
        return kisilerdto;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
