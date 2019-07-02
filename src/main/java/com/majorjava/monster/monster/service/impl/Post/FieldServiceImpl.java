package com.majorjava.monster.monster.service.impl.Post;

import com.majorjava.monster.monster.dao.FieldDao;
import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.service.Post.FieldService;
import com.majorjava.monster.monster.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-19 10:50
 **/
@Service
@Transactional
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldDao fieldDao;

    @Override
    public List<PartitionField> partitionFieldAll() {
        return fieldDao.findByStateOrderByCreateTimeDesc(1);
    }

    @Override
    public PartitionField save(PartitionField partitionField) {
        return fieldDao.save(partitionField);
    }

    @Override
    public void delete(Integer id) {
        PartitionField field = fieldDao.findById(id).get();
        field.setState(0);
        fieldDao.save(field);
    }

    @Override
    public PartitionField finByid(Integer id) {
        return fieldDao.findById(id).get();
    }

    @Override
    public List<PartitionField> findByPartitionId(int id) {
        return fieldDao.findByPartitionId(id);
    }
}
