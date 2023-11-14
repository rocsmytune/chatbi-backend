package com.rocs.chatbi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rocs.chatbi.model.entity.Chart;
import com.rocs.chatbi.service.ChartService;
import com.rocs.chatbi.mapper.ChartMapper;
import org.springframework.stereotype.Service;

/**
* @author Intel
* @description 针对表【chart(图表信息表)】的数据库操作Service实现
* @createDate 2023-11-15 01:08:32
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService{

}




