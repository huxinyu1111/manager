package com.example.mapper;

import com.example.entity.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作goods相关数据接口
*/
public interface GoodsMapper {

    /**
      * 新增
    */
    int insert(Goods goods);

    /**
      * 删除
    */
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Goods goods);

    /**
      * 根据ID查询
    */
    Goods selectById(Integer id);

    /**
      * 查询所有
    */
    List<Goods> selectAll(Goods goods);
/**
 * 根据销量count，倒序排，然后取15个
 */
    @Select("select * from goods order by count desc limit 15")
    List<Goods> selectTop15();
}