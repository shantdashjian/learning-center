package data;

import java.util.List;

import entities.Step;

public interface StepDAO {
  public List<Step> index(int cid);
  public Step show(int cid, int sid);
}