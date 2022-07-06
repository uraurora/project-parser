select
    today.reviewid as ReviewId,
    today.shopid as ShopId,
    cityid as CityId,
    dp_shop_second_cate_id as CategoryId,
    star as Star,
    today.picid as PicId,
    pickey as PicKey,
    if(width IS NULL, 0, width)  as PicWidth,
    if(height IS NULL, 0, height)  as PicHeight,
    wedding_label as Tags,
    today.aes_score as Score,
    if(source <=> 'dp', 1, 2)  as Source
from(
    select
        reviewid,
        shopid,
        cityid,
        dp_shop_first_cate_id,
        dp_shop_second_cate_id,
        star,
        picid,
        pickey,
        width,
        height,
        aes_score,
        wedding_label,
        source
    from
        mart_poistar.ugc_wedding_review_pic_tag_score
    where dt = '$now.delta(1).date'
) as today
LEFT JOIN(
    select
        shopid,
        reviewid,
        picid,
        aes_score,
        dt
    from(
        select
            *,
            dense_rank() over(order by dt desc) rank
        from
            mart_poistar.ugc_wedding_review_pic_tag_score
        where
            dt between '$now.delta(4).date' and '$now.delta(2).date'
    ) t1
    where rank=1
) as yes
ON
    today.reviewid=yes.reviewid and today.picid = yes.picid
where
    (yes.picid IS NULL or yes.aes_score IS NULL)
    or (today.shopid != yes.shopid)
    and today.dp_shop_second_cate_id in (163,33888,6700,162,167)
    and today.star >= 40
    and today.aes_score > 4.8;