package com.axelor.event.db;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.auth.db.User;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Table(name = "EVENT_EVENT", indexes = { @Index(columnList = "user_id") })
public class Event extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_EVENT_SEQ")
	@SequenceGenerator(name = "EVENT_EVENT_SEQ", sequenceName = "EVENT_EVENT_SEQ", allocationSize = 1)
	private Long id;

	private String sujet;

	private String contenu;

	private LocalDateTime start_time;

	private LocalDateTime end_time;

	private LocalDateTime limit_time;

	private Integer duration = 0;

	@Widget(title = "Event_status")
	@Basic
	@Type(type = "com.axelor.db.hibernate.type.ValueEnumType")
	private EventStatus event_status = EventStatus.NOT_STARTED;

	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private User assigned_to;

	@Widget(selection = "selection.association.ref")
	private String ref;

	private Long refId = 0L;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Event() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public LocalDateTime getLimit_time() {
		return limit_time;
	}

	public void setLimit_time(LocalDateTime limit_time) {
		this.limit_time = limit_time;
	}

	public Integer getDuration() {
		return duration == null ? 0 : duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public EventStatus getEvent_status() {
		return event_status;
	}

	public void setEvent_status(EventStatus event_status) {
		this.event_status = event_status;
	}

	public User getAssigned_to() {
		return assigned_to;
	}

	public void setAssigned_to(User assigned_to) {
		this.assigned_to = assigned_to;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Long getRefId() {
		return refId == null ? 0L : refId;
	}

	public void setRefId(Long refId) {
		this.refId = refId;
	}

	public String getAttrs() {
		return attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof Event)) return false;

		final Event other = (Event) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", getId())
			.add("sujet", getSujet())
			.add("contenu", getContenu())
			.add("start_time", getStart_time())
			.add("end_time", getEnd_time())
			.add("limit_time", getLimit_time())
			.add("duration", getDuration())
			.add("event_status", getEvent_status())
			.add("ref", getRef())
			.add("refId", getRefId())
			.omitNullValues()
			.toString();
	}
}
