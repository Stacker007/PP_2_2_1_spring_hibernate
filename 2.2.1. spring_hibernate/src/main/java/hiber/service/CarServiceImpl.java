package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    public List<Car> listCars() {

        return carDao.listCars();
    }
}
