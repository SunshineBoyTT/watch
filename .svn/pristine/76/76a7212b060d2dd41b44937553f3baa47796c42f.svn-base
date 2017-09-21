/**
 * 
 */
package com.spring.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年9月18日
 * @Version:1.1.0
 */
@Entity
@Table(name="tb_monitor")
public class TbMonitor {
	private Integer tbmId;
	private String tbmUrl;
	private String tbmName;
	private String tbmIcon;
	private Integer tbmSort;
	@Id
	@GeneratedValue
	@Column(name = "tbm_id", unique = true, nullable = false)
	public Integer getTbmId() {
		return tbmId;
	}
	public void setTbmId(Integer tbmId) {
		this.tbmId = tbmId;
	}
	@Column(name="tbm_url")
	public String getTbmUrl() {
		return tbmUrl;
	}
	public void setTbmUrl(String tbmUrl) {
		this.tbmUrl = tbmUrl;
	}
	@Column(name="tbm_name")
	public String getTbmName() {
		return tbmName;
	}
	public void setTbmName(String tbmName) {
		this.tbmName = tbmName;
	}
	@Column(name="tbm_icon")
	public String getTbmIcon() {
		return tbmIcon;
	}
	public void setTbmIcon(String tbmIcon) {
		this.tbmIcon = tbmIcon;
	}
	@Column(name="tbm_sort")
	public Integer getTbmSort() {
		return tbmSort;
	}
	public void setTbmSort(Integer tbmSort) {
		this.tbmSort = tbmSort;
	}
	
	
}
