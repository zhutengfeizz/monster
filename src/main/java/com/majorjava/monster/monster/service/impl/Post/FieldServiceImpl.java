package com.majorjava.monster.monster.service.impl.Post;

import com.majorjava.monster.monster.dao.FieldDao;
import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.mapper.FieldMapper;
import com.majorjava.monster.monster.mapper.PostMapper;
import com.majorjava.monster.monster.service.Post.FieldService;
import com.majorjava.monster.monster.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
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
    @Autowired
    private FieldMapper fieldMapper;

    @Override
    public PartitionField addPartitionField(PartitionField partitionField) {
        return fieldDao.save(partitionField);
    }

    @Override
    public List<PartitionField> partitionFieldAll() {
        return fieldMapper.findAll();
    }

    @Override
    public PartitionField add(PartitionField partitionField) {
        return fieldDao.save(partitionField);
    }

    @Override
    public void delete(Long id) {
        PartitionField field = fieldDao.findById(id).get();
        field.setState(0);
        fieldDao.save(field);
    }

    @Override
    public PartitionField finByid(long id) {
        return fieldDao.findById(id).get();
    }

    @Override
    public PartitionField update(PartitionField partitionField) {
         Long id= partitionField.getId().longValue();
        PartitionField f=null;
         if (id!=null){
             PartitionField field = fieldDao.findById(id).get();
             field.setFname(partitionField.getFname());
            f= fieldDao.save(field);
         }else {
             partitionField.setCreateTime(new Timestamp(System.currentTimeMillis()));
            f= fieldDao.save(partitionField);
         }
        return f;
    }
}
